package com.nwq.function.autocodeapp.data

data class FeaturePointBlock(
    val boundaryList: List<FeatureCoordinatePoint>,
    val perimeter: Int,
    val internalList: List<FeatureCoordinatePoint>? = null,
    val depth: Int = 0,
)