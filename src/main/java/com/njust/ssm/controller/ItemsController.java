package com.njust.ssm.controller;

import com.njust.ssm.controller.validation.ItemUpdateValidation;
import com.njust.ssm.exception.CustomerException;
import com.njust.ssm.po.Items;
import com.njust.ssm.po.ItemsCustomer;
import com.njust.ssm.po.ItemsQueryVo;
import com.njust.ssm.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller
public class ItemsController {
    @Autowired
    private IItemsService itemsService;

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception{
        List<ItemsCustomer> itemsCustomers = itemsService.queryItems(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("itemsList");
        modelAndView.addObject("items",itemsCustomers);
        return modelAndView;
    }
    
    @RequestMapping(value="/editItem",method=RequestMethod.GET)
    public void editItem(HttpServletRequest request, HttpServletResponse response,int id) throws Exception{
    	
    	ItemsCustomer itemsCustomer = itemsService.findItemsById(id);
    	
    	if(itemsCustomer==null){
    		throw new CustomerException("id值错误，没有相应的商品！");
    	}
    	
    	request.setAttribute("item",itemsCustomer);
//    	model.addAttribute("item", itemsCustomer);
//    	return "editItem";
    	request.getRequestDispatcher("/WEB-INF/view/editItem.jsp").forward(request, response);
    }
    
    
    @RequestMapping(value="/updateItem",method=RequestMethod.POST)
    public String updateItem(@ModelAttribute("id") Integer id,
    		/*对这个参数进行valdator检验*/
    		@Validated(ItemUpdateValidation.class) @ModelAttribute("item")Items itemcustomer,
    		/*在需要被校验的参数的后面需要紧跟BindingResult来接收校验错误的信息*/
    		BindingResult bindingResult,
    		MultipartFile pictureFile,
    		Model model) throws Exception{
    	
    	if(bindingResult.hasErrors()){
    		model.addAttribute("errors", bindingResult.getAllErrors());
    		List<ObjectError> errors = bindingResult.getAllErrors();
    		for(ObjectError error : errors){
    			System.out.println(error.getDefaultMessage());
    		}
    		
    		return "editItem";
    	}
    	
    	//a博客.png
    	String originalFilename = pictureFile.getOriginalFilename();
    	//找不到返回-1
    	String extension = "";
    	int extensionIndex = -1;
    	if((extensionIndex=originalFilename.lastIndexOf('.'))!=-1){
    		//IndexOutOfBoundsException - 
        	//if beginIndex is negative or larger than the length of this String object.
    		extension = originalFilename.substring(extensionIndex);
    	}
    	
    	String pic = UUID.randomUUID().toString().replace("-", "")+extension;
    	
    	String filePath = "H:\\Picture";
    	
    	File file = new File(filePath+"\\"+pic);
    	
    	pictureFile.transferTo(file);
    	
    	itemcustomer.setPic(pic);
    	
    	itemsService.updateItems(id,itemcustomer);

    	/*model.addAttribute("id",id);*/
    	
    	/*测试数据的回显，springmvc会自动的将pojo类型添加到Model中，key为该pojo的类名首字母小写
    	 * 在这里就会将itemcustomer写到model中，类似于model.addAttribute("itmes",itemcustomer)，
    	 * 如果想要改变Key的值，就必须使用@ModelAttribute(value=key)这个注解
    	 * 但是对于普通类型springmvc并不会这么做，必须手动编写model.addAttribute("")
    	 * 这个注解还可以用在方法的返回值上，适用于将公用的数据的方法的返回值传到页面上，
    	 * 不用再每一个Controller方法中都需要使用Model将数据返回*/
    	return "editItem";
    	//    	return "redirect:queryItems.action";
    }
    
    @ModelAttribute
    public Items getItem(Integer id){
    	Items items = new Items();
    	items.setName("自己添加的");
    	return items;
    }
    
    
    /**
     * 当使用@RequestMapping和@ModelAtribute一起注解一个方法的时候，方法的返回值是会将加入到Model中的
     * 视图名应该是@RequestMapping的value的值，这里就是login
     * 请求的时候也是按照@RequestMapping的value进行请求
     * http://localhost:8080/ssmusemaven/login.action
     */
    @RequestMapping("/login")
    @ModelAttribute("loginname")
    public String login(){
    	return "admin";
    }
    
    @RequestMapping("/editAllItmes")
    public ModelAndView editAllItmes() throws Exception{
    	List<ItemsCustomer> itemsCustomers = itemsService.queryItems(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editItemsList");
        modelAndView.addObject("items",itemsCustomers);
        return modelAndView;
    }
    
    
    /**
     * 将pojo集合数据传递到后端的时候，使用一个类包装这个集合，无论是list，set还是其他的
     * 如果是普通类型的话，那么可以使用该类型的数组进行接收
     * @param itemsQueryVo
     */
    @RequestMapping("/updateAllItmes")
    public void updateAllItmes(ItemsQueryVo itemsQueryVo){
    	
    }
    
    
    @RequestMapping("/jsonpage")
    public String jsonpage() throws Exception{
    	return "jsonrequest";
    }
    
    @RequestMapping("/queryitemsUsejson")
    public @ResponseBody ItemsCustomer queryitemsUsejson(@RequestBody ItemsCustomer ic) throws Exception{
    	ItemsCustomer itemsCustomer = itemsService.findItemsById(ic.getId());
    	return itemsCustomer;
    }
    
    
    
   
    
    
}
