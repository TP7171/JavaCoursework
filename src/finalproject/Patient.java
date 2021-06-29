/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author thiag
 */
public class Patient {

    String name;
    int dOfB;
    String mOfB;
    int yOfB;
    String address;
    String description;
    boolean fire;
    boolean nhs;
    boolean police;
    String dob;

    //Patient Object
    public Patient(String name, int dOfB, String mOfB, int yOfB, String address, String description, boolean fire, boolean nhs, boolean police) {

        this.name = name;
        this.dOfB = dOfB;
        this.mOfB = mOfB;
        this.yOfB = yOfB;
        this.address = address;
        this.description = description;
        this.fire = fire;
        this.nhs = nhs;
        this.police = police;

    }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", dOfB=" + dOfB + ", mOfB=" + mOfB
                + ", yOfB=" + yOfB + ", address=" + address + ", description="
                + description + ", fire=" + fire + ", nhs=" + nhs + ", police=" + police + '}';
    }

    public String getDob() {
        dob = ("" + this.dOfB + "/" + this.mOfB + "/" + this.yOfB);
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getdOfB() {
        return dOfB;
    }

    public void setdOfB(int dOfB) {
        this.dOfB = dOfB;
    }

    public String getmOfB() {
        return mOfB;
    }

    public void setmOfB(String mOfB) {
        this.mOfB = mOfB;
    }

    public int getyOfB() {
        return yOfB;
    }

    public void setyOfB(int yOfB) {
        this.yOfB = yOfB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFire() {
        if (fire) {
            return "X";
        } else {
            return "";
        }
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public String getNhs() {
        if (nhs) {
            return "X";
        } else {
            return "";
        }
    }

    public void setNhs(boolean nhs) {
        this.nhs = nhs;
    }

    public String getPolice() {
        if (police) {
            return "X";
        } else {
            return "";
        }
    }

    public void setPolice(boolean police) {
        this.police = police;
    }

}
