package com.sandeshshetty.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sandeshshetty.core.database.dao.EmployeeDao
import com.sandeshshetty.core.database.entity.EmployeeEntity

/**
 * @author sandeshshetty
 * Created 5/28/25 at {TIME}
 */
@Database(
    entities = [EmployeeEntity::class],
    version = 1
)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract val employeeDao: EmployeeDao
}