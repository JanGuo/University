package com.janguo.javabasic.lambda.collect;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollect<T> implements Collector<T,Set<T>, Map<T,T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("Supplier Invoke");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("Accumulator Invoke");
        return (set,item) ->{
            System.out.println("Accumulator:"+set+Thread.currentThread().getName()); // 过程中取Set 就会出现问题ConcurrentModification（）并行修改错误
//            System.out.println("Accumulator:"+Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("Combiner Invoke");
        return (set1,set2)->{
            System.out.println("Set1:" +set1);
            System.out.println("Set2:" +set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T,T>> finisher() {
        System.out.println("Finisher Invoke");
        return (set -> {
            HashMap map = new HashMap<T,T>();
            set.stream().forEach(item ->map.put(item,item) );
            return map;
        });
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            List<String> stringList = Arrays.asList("nihao", "hello", "welcome", "a", "b", "s", "v", "world");

            HashSet<String> hashSet = new HashSet<>();
            hashSet.addAll(stringList);

            Map<String, String> map = hashSet.parallelStream().collect(new MyCollect<>());

            System.out.println(map);
        }



    }
}
