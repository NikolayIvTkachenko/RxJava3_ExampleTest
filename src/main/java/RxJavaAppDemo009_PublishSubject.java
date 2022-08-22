import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

public class RxJavaAppDemo009_PublishSubject {


    public static void main(String[] args) {

        Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

        @NonNull
        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(item -> System.out.println("Received item " + item));

        source1.subscribe(subject);
        source2.subscribe(subject);

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
