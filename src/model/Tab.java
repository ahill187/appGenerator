package model;

import shiny.TabItem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tab {

    private String tabId;
    private String tabTitle;
    private Map<String, AppBrick> appBrickHash = new HashMap<>();
    private Map<String, TabBox> tabBoxHash = new HashMap<>();
    private TabItem tabItem;
    private String filename;

    public Tab(String tabId, String tabTitle, Map<String, AppBrick> appBrickHash, String filename) {
        this.tabId = tabId;
        this.tabTitle = tabTitle;
        this.appBrickHash = appBrickHash;
        this.filename = filename;
        this.tabItem = new TabItem(this.tabId, this.filename);
    }

    public Map<String, AppBrick> getAppBrickHash() {
        return appBrickHash;
    }

    public void setAppBrickHash(Map<String, AppBrick> appBrickHash) {
        this.appBrickHash = appBrickHash;
    }

    public void addToAppBrickHash(String key, AppBrick brick){
        if(!appBrickHash.containsKey(key)){
            appBrickHash.put(key, brick);
        }
    }

    public Map<String, TabBox> getTabBoxHash() {
        return tabBoxHash;
    }

    public void setTabBoxHash(Map<String, TabBox> tabBoxHash) {
        this.tabBoxHash = tabBoxHash;
    }

    public void writeUiTab() throws IOException {
        this.tabItem.startTabItem();
        if(!appBrickHash.isEmpty()){

            for(AppBrick appBrick : appBrickHash.values()){
                appBrick.writeUiBrick();
            }
        }
        if(!tabBoxHash.isEmpty()){
            System.out.println("Huh");
            for(TabBox tabBox : tabBoxHash.values()){
                tabBox.startBox();
            }
        }
        this.tabItem.endTabItem();
    }

    public void writeServerTab(){
        for(AppBrick appBrick : appBrickHash.values()){
            appBrick.writeServerBrick();
        }
    }

}
