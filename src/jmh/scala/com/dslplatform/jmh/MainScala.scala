package com.dslplatform.jmh

import java.util.{ List => JList }
import com.dslplatform.example._
import scala.collection.JavaConverters._

object MainScala {
  def convertEntitySnapshot(entitySnapshot: dto.EntitySnapshot) =
    EntitySnapshot(
      entity = convertEntity(entitySnapshot.getEntity)
    , metrics = IndexedSeq.empty ++ entitySnapshot.getMetrics.asScala map { convertMetric }
    )

  def convertEntity(entity: dto.Entity) =
    Entity(
      name = entity.getName
    , category = entity.getCategory
    )

  def convertMetric(metric: dto.Metric) =
    Metric(
      name = metric.getName
    , metricType = metric.getMetricType
    , snapshot = metric.getSnapshot
    )

  def convertPayload(payload: JList[dto.EntitySnapshot]) =
    IndexedSeq.empty ++ payload.asScala map { convertEntitySnapshot }
}
