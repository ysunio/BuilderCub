package Archieve.DesignPattern;

import java.util.Objects;

public class SingletonPattern {
    class EagerSingleton{
        private final EagerSingleton eagerSingleton = new EagerSingleton();
        public EagerSingleton getInstance(){
            return eagerSingleton;
        }
    }

    class LazySingleton{
        private LazySingleton lazySingleton;
        public LazySingleton getInstance(){
            return Objects.requireNonNullElseGet(this.lazySingleton, LazySingleton::new);
        }
    }
}
