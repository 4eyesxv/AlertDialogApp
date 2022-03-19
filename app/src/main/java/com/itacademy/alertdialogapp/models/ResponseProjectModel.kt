package com.itacademy.alertdialogapp.models

data class ResponseProjectModel(
    val projects: List<ProjectModel>
)

data class ProjectModel(
    val projectId: Int,
    val lastUpdated: String
)