package com.fg716.util

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File

//读写SD卡工具类
public class ExternalStorageUtil {


    companion object {
        /* Checks if external storage is available for read and write */
        fun isExternalStorageWritable(): Boolean {
            return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
        }

        /* Checks if external storage is available to at least read */
        fun isExternalStorageReadable(): Boolean {
            return Environment.getExternalStorageState() in
                    setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
        }

        fun getPublicAlbumStorageDir(albumName: String): File? {
            // Get the directory for the user's public pictures directory.
            val file = File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES), albumName)
            if (!file?.mkdirs()) {
                Log.e("zhf", "Directory not created")
            }
            return file
        }

        fun getPrivateAlbumStorageDir(context: Context, albumName: String): File? {
            // Get the directory for the app's private pictures directory.
            val file = File(context.getExternalFilesDir(
                    Environment.DIRECTORY_PICTURES), albumName)
            if (!file?.mkdirs()) {
                Log.e("zhf", "Directory not created")
            }
            return file
        }
    }


}