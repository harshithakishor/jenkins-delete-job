import jenkins.model.*
import jenkins.model.Jenkins
import hudson.model.Job

def deleteJob(deleteRegex) {
    def deleteJobPat = deleteRegex
    def matchedJobs = Jenkins.instance.items.findAll { job ->
        job.name =~ /${deleteJobPat}/
}
matchedJobs.each { job ->
    job.delete()
}
}

@NonCPS
def deleteBuild() {
minimum_builds = 3

	
for (job in Jenkins.instance.items) {
  println job.name

  def recent = job.builds.limit(minimum_builds)
    try {
  for (build in job.builds) {
	 
    if (!recent.contains(build)) {
	    
	  def build_time = build.getTime()
	  use (groovy.time.TimeCategory) {
		def current_date = new Date()
		def duration = current_date - build_time
	if(duration.hours>1) {
        	println "deleting  - ${build} , it is ${duration.hours} hours old"
         build.delete()
       }
      }
    }
		  
  }
    }catch(Exception ex) {
                println ' Ignoring exception ' + ex
            }
  
}

}
return this
