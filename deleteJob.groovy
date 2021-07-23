import jenkins.model.*
def hi(deleteRegex) {
    def deleteJobPat = deleteRegex
    def matchedJobs = Jenkins.instance.items.findAll { job ->
        job.name =~ /${deleteJobPat}/
}
matchedJobs.each { job ->
    job.delete()
}
}
return this
