package com.example.alex.practise_app.model;

/**
 * Created by Alex on 6/12/2017.
 */

public class Hero  {

    String codeName,realName,superPower;

    public Hero(String codeName, String realName, String superPower) {
        this.codeName = codeName;
        this.realName = realName;
        this.superPower = superPower;
    }


    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
