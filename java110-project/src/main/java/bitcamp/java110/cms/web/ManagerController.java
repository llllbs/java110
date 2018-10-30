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

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController { 
    
    ManagerService managerService;
    ServletContext sc;
    
    
    public ManagerController(ManagerService managerService, ServletContext sc) {
        this.managerService = managerService;
        this.sc = sc;
    }

    @GetMapping("form")
    public void form() {
        
    }
    
    @PostMapping("add")
    public String add(Manager manager
            , MultipartFile file1) throws Exception {


        if (file1.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            manager.setPhoto(filename);
        }
        
        managerService.add(manager);
        return "redirect:list";
    }
    
    @GetMapping("delete")
    public String delete(int no) throws Exception {
        
        managerService.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("list")
    public void list(@RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="3") int pageSize, Model model) {
        
            if (pageNo < 1)
                pageNo = 1;
        
            
            if (pageSize < 3 || pageSize > 10)
                pageSize = 3;
       
        
        List<Manager> list = managerService.list(pageNo, pageSize);
        model.addAttribute("list",list);

    }
    
    @GetMapping("detail")
    public void detail(int no
            , Model model) {

        Manager m = managerService.get(no);
        model.addAttribute("manager", m);
    }
    
}