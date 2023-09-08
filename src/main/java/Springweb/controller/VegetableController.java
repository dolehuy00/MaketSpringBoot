package Springweb.controller;




import Springweb.*;
import Springweb.entity.Category;
import Springweb.entity.OrderDetail;
import Springweb.entity.Vegetable;
import Springweb.repository.CategoryRepository;
import Springweb.repository.OrderdetailRepository;
import Springweb.repository.VegetableRepository;
import java.util.ArrayList;
import java.util.Iterator;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author caothanh
 */
@Controller
public class VegetableController {

    @Autowired
    private VegetableRepository vegetableRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderdetailRepository orderdetailRepository;

    @GetMapping("/")
    public String getAll(Model m) {
        Iterable<Vegetable> list = vegetableRepository.findAll();
        m.addAttribute("vegetable", list);
        Iterable<Category> listCategorys = categoryRepository.findAll();
        m.addAttribute("category", listCategorys);
        return "VegetableView";
    }

    @PostMapping("/process-form")
    public String processForm(@RequestParam("input-field") String input, HttpServletRequest request, Model model) {
        Iterable<Vegetable> list = vegetableRepository.findAll();
        Iterable<Category> listCategorys = categoryRepository.findAll();
        model.addAttribute("category", listCategorys);

        String selectedOption = request.getParameter("selectOptionName");
        
        model.addAttribute("selectedOption", selectedOption);
        
        List<Vegetable> listVegetable = (List<Vegetable>) list;

        if (selectedOption.contains("Bán chạy")) {

            model.addAttribute("vegetableKey", this.sanPhamBanChay(listVegetable));

        } else { // Xem sản phẩm theo loại ------ Tìm kiếm theo tên, loại
            List<Vegetable> listVegetableAfterSearch = new ArrayList<Vegetable>();

            int inputIsHas = 0;
            int selectedOptionIsHas = 0;
            if (input.trim().length() > 0) {
                inputIsHas = 1;
            }
            if (selectedOption.length() > 0) {
                selectedOptionIsHas = 1;
            }

            for (Vegetable vegetable : listVegetable) {
                if (inputIsHas == 0
                        && selectedOptionIsHas == 1
                        && vegetable.getCategory().getName().contains(selectedOption)) {
                    listVegetableAfterSearch.add(vegetable);
                } else if (inputIsHas == 1
                        && selectedOptionIsHas == 0
                        && vegetable.getVegetableName().toLowerCase().contains(input.toLowerCase())) {
                    listVegetableAfterSearch.add(vegetable);
                } else if (inputIsHas == 1
                        && selectedOptionIsHas == 1
                        && vegetable.getCategory().getName().contains(selectedOption)
                        && vegetable.getVegetableName().toLowerCase().contains(input.toLowerCase())) {
                    listVegetableAfterSearch.add(vegetable);
                }
            }
            Object[][] objectses = new Object[listVegetableAfterSearch.size()][8];

            List<OrderDetail> listOrderdetails = (List<OrderDetail>) orderdetailRepository.findAll();

            int i = 0;
            for (Vegetable vegetable : listVegetableAfterSearch) {
                objectses[i][0] = vegetable.getImage();
                objectses[i][1] = vegetable.getCategory().getName();
                objectses[i][2] = vegetable.getVegetableID();
                objectses[i][3] = vegetable.getVegetableName();
                objectses[i][4] = vegetable.getPrice();
                objectses[i][5] = vegetable.getUnit();
                objectses[i][6] = vegetable.getAmount();

                int tongSoLuongDaBanDuoc = 0;

                Iterator<OrderDetail> iterator = listOrderdetails.iterator();
                while (iterator.hasNext()) {
                    OrderDetail orderdetail = iterator.next();
                    if (vegetable.getVegetableID() == orderdetail.getVegetable().getVegetableID()) {
                        tongSoLuongDaBanDuoc += Integer.valueOf(orderdetail.getQuantity());
                        iterator.remove();
                    }
                }

                objectses[i][7] = tongSoLuongDaBanDuoc;

                i++;
            }

            model.addAttribute("vegetableKey", objectses);
        }

        return "VegetableView";
    }

    public Object[][] sanPhamBanChay(List<Vegetable> listVegetable) {

        Object[][] objectses = new Object[listVegetable.size()][8];

        List<OrderDetail> listOrderdetails = (List<OrderDetail>) orderdetailRepository.findAll();

        int i = 0;
        for (Vegetable vegetable : listVegetable) {
            objectses[i][0] = vegetable.getImage();
            objectses[i][1] = vegetable.getCategory().getName();
            objectses[i][2] = vegetable.getVegetableID();
            objectses[i][3] = vegetable.getVegetableName();
            objectses[i][4] = vegetable.getPrice();
            objectses[i][5] = vegetable.getUnit();
            objectses[i][6] = vegetable.getAmount();

            int tongSoLuongDaBanDuoc = 0;

            Iterator<OrderDetail> iterator = listOrderdetails.iterator();
            while (iterator.hasNext()) {
                OrderDetail orderdetail = iterator.next();
                if (vegetable.getVegetableID() == orderdetail.getVegetable().getVegetableID()) {
                    tongSoLuongDaBanDuoc += Integer.valueOf(orderdetail.getQuantity());
                    iterator.remove();
                }
            }

            objectses[i][7] = tongSoLuongDaBanDuoc;

            i++;
        }

        for (int ii = 0; ii < objectses.length - 1; ii++) {
            for (int j = 0; j < objectses.length - ii - 1; j++) {
                if ((Integer) objectses[j][7] < (Integer) objectses[j + 1][7]) {
                    Object[] temp = objectses[j];
                    objectses[j] = objectses[j + 1];
                    objectses[j + 1] = temp;
                }
            }
        }
        
        return objectses;
    }
    
}
