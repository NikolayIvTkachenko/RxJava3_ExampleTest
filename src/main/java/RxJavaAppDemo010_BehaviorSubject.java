import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

import javax.security.auth.Subject;

public class RxJavaAppDemo010_BehaviorSubject {

    public static void main(String[] args) {

        @NonNull
        BehaviorSubject<Object> subject = BehaviorSubject.create();

        subject.subscribe(item -> System.out.println("Person 1 listens to song: " + item));

        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        subject.subscribe(item -> System.out.println("Person 2 listens to song: " + item));


    }


}
