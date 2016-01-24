# dsl-json-jmh
Sandbox for testing real world models with DSL Platfom serialization (JMH)

    Benchmark               (SNAPSHOT_COUNT)  Mode  Cnt       Score       Error  Units
    Main.benchDslJsonJava                 10  avgt   15     377.039 ±     1.267  us/op
    Main.benchDslJsonScala                10  avgt   15     323.720 ±     0.289  us/op
    Main.benchJacksonJava                 10  avgt   15     779.671 ±    11.856  us/op
    Main.benchJacksonScala                10  avgt   15     792.959 ±    15.260  us/op
    Main.benchDslJsonJava                100  avgt   15    3435.892 ±     0.810  us/op
    Main.benchDslJsonScala               100  avgt   15    2818.029 ±     2.555  us/op
    Main.benchJacksonJava                100  avgt   15    7142.897 ±    36.721  us/op
    Main.benchJacksonScala               100  avgt   15    6953.556 ±    48.167  us/op
    Main.benchDslJsonJava               1000  avgt   15   34773.998 ±    46.472  us/op
    Main.benchDslJsonScala              1000  avgt   15   27821.875 ±   410.595  us/op
    Main.benchJacksonJava               1000  avgt   15   69159.960 ±    40.466  us/op
    Main.benchJacksonScala              1000  avgt   15   69430.517 ±   180.625  us/op
    Main.benchDslJsonJava              10000  avgt   15  335578.884 ±  3487.731  us/op
    Main.benchDslJsonScala             10000  avgt   15  270210.826 ±   414.804  us/op
    Main.benchJacksonJava              10000  avgt   15  674408.266 ± 22543.054  us/op
    Main.benchJacksonScala             10000  avgt   15  662559.029 ± 23288.539  us/op
