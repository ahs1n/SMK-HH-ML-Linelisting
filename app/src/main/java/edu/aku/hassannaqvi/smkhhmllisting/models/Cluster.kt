package edu.aku.hassannaqvi.smkhhmllisting.models

import android.database.Cursor
import edu.aku.hassannaqvi.smkhhmllisting.contracts.TableContracts.ClusterTable
import edu.aku.hassannaqvi.smkhhmllisting.core.MainApp._EMPTY_
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 11/30/2016.
 */
class Cluster {
    var ID: Long = 0
    var geoarea: String = _EMPTY_
    var distId: String = _EMPTY_
    var cluster_no: String = _EMPTY_


    constructor() {
        // Default Constructor
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Cluster {
        geoarea = jsonObject.getString(ClusterTable.COLUMN_GEOAREA)
        distId = jsonObject.getString(ClusterTable.COLUMN_DIST_ID)
        cluster_no = jsonObject.getString(ClusterTable.COLUMN_CLUSTER_CODE)


        return this
    }

    fun hydrate(cursor: Cursor): Cluster {
        ID = cursor.getLong(cursor.getColumnIndexOrThrow(ClusterTable.COLUMN_ID))

        geoarea = cursor.getString(cursor.getColumnIndexOrThrow(ClusterTable.COLUMN_GEOAREA))
        distId = cursor.getString(cursor.getColumnIndexOrThrow(ClusterTable.COLUMN_DIST_ID))
        cluster_no =
            cursor.getString(cursor.getColumnIndexOrThrow(ClusterTable.COLUMN_CLUSTER_CODE))


        return this
    }


}