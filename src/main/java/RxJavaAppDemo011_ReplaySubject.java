import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.ReplaySubject;

import javax.security.auth.Subject;

public class RxJavaAppDemo011_ReplaySubject {

    public static void main(String[] args) {

        @NonNull
        ReplaySubject<Object> subject = ReplaySubject.create();

        subject.subscribe(item -> System.out.println("Worker A received " + item));

        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        subject.subscribe(item -> System.out.println("Worker B received " + item));

    }

}
