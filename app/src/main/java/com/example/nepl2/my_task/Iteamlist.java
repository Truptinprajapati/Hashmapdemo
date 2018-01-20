package com.example.nepl2.my_task;

/**
 * Created by nepl2 on 20/1/18.
 */

class Iteamlist {

    int rowid,srno,postid;

    String posttype,posttitle,photo1,photo2,photo3,photo4,photo5,postby,tags,shortdescription,postdescription;


    public Iteamlist(int rowid,int srno,int postid,String posttype,String posttitle,String photo1,
                     String photo2,String photo3,String photo4,String photo5,String postby,
                     String tags,String shortdescription,String postdescription){
        this.rowid=rowid;
        this.srno=srno;
        this.postid=postid;
        this.posttype=posttype;
        this.posttitle=posttitle;
        this.photo1=photo1;
        this.photo2=photo2;
        this.photo3=photo3;
        this.photo4=photo4;
        this.photo5=photo5;
        this.postby=postby;
        this.tags=tags;
        this.shortdescription=shortdescription;
        this.postdescription=postdescription;
    }

    public int getRowid() {
        return rowid;
    }

    public int getSrno() {
        return srno;
    }

    public int getPostid() {
        return postid;
    }

    public String getPosttype() {
        return posttype;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public String getPhoto1() {
        return photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public String getPhoto4() {
        return photo4;
    }

    public String getPhoto5() {
        return photo5;
    }

    public String getPostby() {
        return postby;
    }

    public String getPostdescription() {
        return postdescription;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public String getTags() {
        return tags;
    }
}
