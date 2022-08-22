import io.reactivex.rxjava3.subjects.AsyncSubject;

public class RxJavaAppDemo012_AsyncSubject {

    public static void main(String[] args) {

        AsyncSubject<Integer> subject = AsyncSubject.create();

        subject.subscribe(item -> System.out.println("Worker A received " + item));

        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        subject.subscribe(item -> System.out.println("Worker B received " + item));

        subject.onNext(4);

        subject.onComplete();

    }

}
