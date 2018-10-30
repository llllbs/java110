package bitcamp.java110.cms.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    

    ServletContext sc;
    StudentService studentService;
    
    
    
    public StudentController(ServletContext sc, StudentService studentService) {
        this.sc = sc;
        this.studentService = studentService;
    }


    @GetMapping("form")
    public void form() {
        
    }
    
    
    @GetMapping("list")
    public void list(@RequestParam(value="pageNo", defaultValue="1") int pageNo
            ,@RequestParam(value="pageSize", defaultValue="3") int pageSize
            , Model model) {

            if (pageNo < 1)
                pageNo = 1;
        
       
            if (pageSize < 3 || pageSize > 10)
                pageSize = 3;
        
        
        List<Student> list = studentService.list(pageNo, pageSize);
        model.addAttribute("list",list);
    }
    
    @PostMapping("add")
    public String add(Student student
            ,MultipartFile file1) throws Exception {
       
        if (file1.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            student.setPhoto(filename);
        }
        
        studentService.add(student);
        return "redirect:list";
        
    }
    
    @GetMapping("delete")
    public String delete(int no) throws Exception {

        studentService.delete(no);
        return "redirect:list";
    }
    
    @GetMapping("detail")
    public void detail(int no
            , Model model) {

        Student s = studentService.get(no);
        model.addAttribute("student", s);
    }
}
