package com.gayratrakhimov.rxjavaexamples.examples.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FilteringOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable1 = Observable.just(5, 3, 2, 4);

        // filter
//        Observable observable2 = observable1.filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) throws Exception {
//                return integer >= 4;
//            }
//        });

        // takeLast
        Observable observable2 = observable1.takeLast(2);

        // lastOrDefault
        // takeLastBuffer
        // skip
        // skipLast
        // take
        // first and takeFirst
        // firstOrDefault
        // elementAt
        // elementAtOrDefault
        // sample or throttleLast
        // throttleFirst
        // throttleWithTimeout or debounce
        // timeout
        // distinct
        // distrinctUntilChanged
        // ofType
        // ignoreElements

        final Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

        observable2.subscribe(observer);

    }

}
