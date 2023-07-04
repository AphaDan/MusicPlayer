package com.shuai.musicplayer2.api;


import com.shuai.musicplayer2.domain.MusicInfo;
import com.shuai.musicplayer2.domain.MusicList;
import com.shuai.musicplayer2.domain.MusicUrl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/search")
    Call<MusicList> getMusicList(@Query("keywords") String keywords);

    @GET("/song/detail")
    Call<MusicInfo> getMusicInfo(@Query("ids") String ids);

    @GET("/song/url")
    Call<MusicUrl> getMusicUrl(@Query("id") String id);

}
