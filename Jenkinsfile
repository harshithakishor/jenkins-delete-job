node {
	stage "git clone groovy"
		git url: 'https://github.com/harshithakishor/jenkins-delete-job.git', branch: 'main'
	stage "delete Job"
		def deleteModule = load "deleteJob.groovy"
		deleteModule.deleteFunc(params.deleteJobRegex)
}
