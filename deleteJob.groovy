import jenkins.model.*
def hi() {
    def matchedJobs = Jenkins.instance.items.findAll { job ->
    job.name =~ /test/
}
matchedJobs.each { job ->
    job.delete()
}
}
return this
