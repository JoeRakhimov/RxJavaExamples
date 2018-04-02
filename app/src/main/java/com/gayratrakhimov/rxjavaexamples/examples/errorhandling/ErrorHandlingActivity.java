package com.gayratrakhimov.rxjavaexamples.examples.errorhandling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ErrorHandlingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_handling);

        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Marshmallow");
                emitter.onNext("Nougat");
                emitter.onNext("Oreo");
//                emitter.onError(new Throwable("This is throwable"));
                emitter.onError(new RuntimeException("This is runtime exception"));
                emitter.onComplete();
            }
        });

        Observable observable2 = Observable.just("1","2","3");

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext: "+o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

        // onErrorReturn
//        observable = observable.onErrorReturn(new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                return "P";
//            }
//        });

        // onErrorResumeNext
        // throwable: yes
        // runtime exception: yes
//        observable = observable.onErrorResumeNext(observable2);

        // onExceptionResumeNext
        // throwable: no
        // runtime exception: yes
//        observable = observable.onExceptionResumeNext(observable2);

        // subscribe
        observable.subscribe(observer);

    }

}
