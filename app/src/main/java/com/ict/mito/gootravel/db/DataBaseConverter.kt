package com.ict.mito.gootravel.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.ict.mito.gootravel.spot.model.RegisterPointData
import java.io.ByteArrayOutputStream

/**
 * Created by mitohato14 on 2019-08-28.
 */
class DataBaseConverter {
    fun convert2RoomRegisterLocation(registerPointData: RegisterPointData): RoomRegisterLocation {
        val baos = ByteArrayOutputStream()
        registerPointData.spotBitmap?.compress(
            Bitmap.CompressFormat.JPEG,
            100,
            baos
        )
        val imageByteArray = baos.toByteArray()

        return RoomRegisterLocation(
            id = registerPointData.id.toLong(),
            name = registerPointData.name,
            latitude = registerPointData.latitude,
            longitude = registerPointData.longitude,
            notificationTime = registerPointData.notificationTime.toDouble(),
            image = imageByteArray,
            memo = registerPointData.memo
        )
    }

    fun convert2RegisterPointData(roomRegisterLocation: RoomRegisterLocation): RegisterPointData {
        return RegisterPointData(
            id = roomRegisterLocation.id.toInt(),
            name = roomRegisterLocation.name,
            memo = roomRegisterLocation.memo,
            latitude = roomRegisterLocation.latitude,
            longitude = roomRegisterLocation.longitude,
            notificationTime = roomRegisterLocation.notificationTime.toInt(),
            spotBitmap = BitmapFactory.decodeByteArray(
                roomRegisterLocation.image,
                0,
                roomRegisterLocation.image.size
            )
        )
    }

    fun convert2RoomRegisterLocationList(
        registerPointDataList: List<RegisterPointData>
    ): List<RoomRegisterLocation> {
        val array: ArrayList<RoomRegisterLocation> = arrayListOf()
        registerPointDataList.map {
            array.add(convert2RoomRegisterLocation(it))
        }

        return array.toList()
    }

    fun convert2RegisterPointDataList(
        roomRegisterLocationList: List<RoomRegisterLocation>
    ): List<RegisterPointData> {
        val array: ArrayList<RegisterPointData> = arrayListOf()
        roomRegisterLocationList.map {
            array.add(convert2RegisterPointData(it))
        }

        return array.toList()
    }
}
