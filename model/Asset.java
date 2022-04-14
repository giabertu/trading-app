package model;

public abstract class Asset {

    private final String type;

    public Asset(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
    
}
