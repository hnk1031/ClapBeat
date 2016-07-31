package com.lifeistech.android.clapbeat;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by hnk_1031 on 16/07/30.
 */
public class Clap {
    //音楽プレイヤー
    private SoundPool soundPool;
    //読み込んだ音声のID
    private int soundId;

    //Clapインスタンスを作り、初期化する
    public Clap(Context context) {
        //新しいSoundPoolインスタンスを生成
        soundPool=new SoundPool(1, AudioManager.STREAM_MUSIC,0);

        //音声ファイルを読み込む
        soundId=soundPool.load(context,R.raw.clap2,1);
    }

    //音声を再生するメソッド
    public void play(){
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {

            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

                if (status == 0) {
                    soundPool.play(sampleId,1.0F,1.0F,0,0,1.0F);
                }

            }
        });
    }

    //手拍子を再生するメソッド
    public void repeatPlay(int repeat) {
        //繰り返した回数をカウントする変数
        int count = 0;

        while (count< repeat) {
            //playメソッドで音声を再生
            play();
            //繰り返しカウントを1増やす
            count ++;

            try {
                //500ミリ秒待つ
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
