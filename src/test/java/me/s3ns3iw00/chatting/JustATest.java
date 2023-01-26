package me.s3ns3iw00.chatting;

import de.mkammerer.snowflakeid.SnowflakeIdGenerator;
import de.mkammerer.snowflakeid.options.Options;
import de.mkammerer.snowflakeid.structure.Structure;
import de.mkammerer.snowflakeid.time.MonotonicTimeSource;
import de.mkammerer.snowflakeid.time.TimeSource;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class JustATest {

    public static void main(String[] args) {
        /*AtomicLong identifier = new AtomicLong(System.currentTimeMillis() * 1000);
        System.out.println(identifier.incrementAndGet());

        System.out.println(Long.parseLong("something", 36));*/

        /*TimeSource timeSource = new MonotonicTimeSource(Instant.now());
        Structure structure = new Structure(30, 5, 28);
        Options options = new Options(Options.SequenceOverflowStrategy.THROW_EXCEPTION);

        long generatorId = 30;
        SnowflakeIdGenerator generator = SnowflakeIdGenerator.createCustom(generatorId, timeSource, structure, options);*/

        /*SnowflakeIdGenerator generator = SnowflakeIdGenerator.createDefault(1);
        SnowflakeIdGenerator generator2 = SnowflakeIdGenerator.createDefault(1);

        for (int i = 0; i < 10; i++) {
            long id = generator.next();
            System.out.println(id);
        }
        System.out.println("============");
        for (int i = 0; i < 10; i++) {
            long id = generator2.next();
            System.out.println(id);
        }*/

        Snowflake snowflake = new Snowflake(0);
        Snowflake snowflake2 = new Snowflake(0);

        for (int i = 0; i < 10; i++) {
            long id = snowflake.nextId();
            System.out.println(id);
        }
        System.out.println("=====");
        for (int i = 0; i < 10; i++) {
            long id = snowflake2.nextId();
            System.out.println(id);
        }
    }

}
