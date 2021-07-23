import jenkins.model.*
def deleteFunc(deleteRegex) {
    def deleteJobPat = deleteRegex
    def matchedJobs = Jenkins.instance.items.findAll { job ->
        job.name =~ /${deleteJobPat}/
}
matchedJobs.each { job ->
    job.delete()
}
}
return this
