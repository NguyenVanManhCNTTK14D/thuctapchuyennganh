package com.example.nguyenmanh.gogo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Album  implements Serializable {

@SerializedName("IdAlbum")
@Expose
private String idAlbum;
@SerializedName("TenAlbum")
@Expose
private String tenAlbum;
@SerializedName("TenCaSiAlbum")
@Expose
private String tenCaSiAlbum;
@SerializedName("HinhanhAlbum")
@Expose
private String hinhanhAlbum;

public String getIdAlbum() {
return idAlbum;
}

public void setIdAlbum(String idAlbum) {
this.idAlbum = idAlbum;
}

public String getTenAlbum() {
return tenAlbum;
}

public void setTenAlbum(String tenAlbum) {
this.tenAlbum = tenAlbum;
}

public String getTenCaSiAlbum() {
return tenCaSiAlbum;
}

public void setTenCaSiAlbum(String tenCaSiAlbum) {
this.tenCaSiAlbum = tenCaSiAlbum;
}

public String getHinhanhAlbum() {
return hinhanhAlbum;
}

public void setHinhanhAlbum(String hinhanhAlbum) {
this.hinhanhAlbum = hinhanhAlbum;
}

}