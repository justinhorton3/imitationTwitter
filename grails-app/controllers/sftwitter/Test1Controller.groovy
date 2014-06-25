package sftwitter



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Test1Controller {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Test1.list(params), model:[test1InstanceCount: Test1.count()]
    }

    def show(Test1 test1Instance) {
        respond test1Instance
    }

    def create() {
        respond new Test1(params)
    }

    @Transactional
    def save(Test1 test1Instance) {
        if (test1Instance == null) {
            notFound()
            return
        }

        if (test1Instance.hasErrors()) {
            respond test1Instance.errors, view:'create'
            return
        }

        test1Instance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'test1.label', default: 'Test1'), test1Instance.id])
                redirect test1Instance
            }
            '*' { respond test1Instance, [status: CREATED] }
        }
    }

    def edit(Test1 test1Instance) {
        respond test1Instance
    }

    @Transactional
    def update(Test1 test1Instance) {
        if (test1Instance == null) {
            notFound()
            return
        }

        if (test1Instance.hasErrors()) {
            respond test1Instance.errors, view:'edit'
            return
        }

        test1Instance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Test1.label', default: 'Test1'), test1Instance.id])
                redirect test1Instance
            }
            '*'{ respond test1Instance, [status: OK] }
        }
    }

    @Transactional
    def delete(Test1 test1Instance) {

        if (test1Instance == null) {
            notFound()
            return
        }

        test1Instance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Test1.label', default: 'Test1'), test1Instance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'test1.label', default: 'Test1'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
