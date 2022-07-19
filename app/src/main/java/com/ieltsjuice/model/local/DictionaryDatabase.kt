package com.ieltsjuice.model.local



//@Database(entities = [DictionaryLocalDataClass::class], version = 1, exportSchema = false)
//abstract class DictionaryDatabase : RoomDatabase() {

//    abstract val dictionaryDao: DictionaryDao
//
//    companion object {
//        @Volatile
//        private var database: DictionaryDatabase? = null
//
//        fun getDatabase(context: Context): DictionaryDatabase {
//            synchronized(this) {
//                if (database == null) {
//                    database = Room.databaseBuilder(
//                        context.applicationContext,
//                        DictionaryDatabase::class.java,
//                        "DictionaryDatabase.db"
//                    )
//                        .build()
//                }
//                return database!!
//            }
//        }
//    }
//}