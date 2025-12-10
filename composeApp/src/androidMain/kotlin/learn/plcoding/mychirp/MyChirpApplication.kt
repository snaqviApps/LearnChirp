package learn.plcoding.mychirp

import android.app.Application
import learn.plcoding.mychirp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MyChirpApplication : Application() {

    /**
     * This onCreate() call goes out ONCE, not in MainActivity's onCreate() that can go out multiple-times, e.g:  for every configuration change
     */
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyChirpApplication)
            androidLogger()
        }
    }
}
