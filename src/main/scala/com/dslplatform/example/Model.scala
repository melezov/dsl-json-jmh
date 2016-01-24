package com.dslplatform.example

case class EntitySnapshot(entity: Entity, metrics: Seq[Metric])
case class Entity(category: String, name: String)
case class Metric(name: String, metricType: String, snapshot: Array[Long])
