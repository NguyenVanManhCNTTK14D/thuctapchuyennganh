package com.example.nguyenmanh.gogo.Server;

import com.example.nguyenmanh.gogo.Model.Album;
import com.example.nguyenmanh.gogo.Model.Baihat;
import com.example.nguyenmanh.gogo.Model.Playlist;
import com.example.nguyenmanh.gogo.Model.Quangcao;
import com.example.nguyenmanh.gogo.Model.Theloai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

   @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();
   @GET("chudevatheloai.php")
   Call<List<Theloai>> GetTheLoai();

   @GET("albumhot.php")
       Call<List<Album>> GetAlbumHot();

   @GET("baihatduocthich.php")
    Call<List<Baihat>> GetBaiHatHot();

   @FormUrlEncoded
   @POST("danhsachbaihat.php")
   Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

   @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> Getdanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

   @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();

   @GET("tatcaalbum.php")
    Call<List<Album>> GetAlbum();
   @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

   @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> Updateluotthich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

   @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<Baihat>> Getseachbaihat(@Field("tukhoa") String tukhoa);


}
