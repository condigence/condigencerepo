package com.digitmarket.defaultstore.vendor.rest;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digitmarket.defaultstore.vendor.bean.ProductBean;
import com.digitmarket.defaultstore.vendor.bean.ProductImageBean;
import com.digitmarket.defaultstore.vendor.dto.ProductDTO;
import com.digitmarket.defaultstore.vendor.service.ProductService;
import com.digitmarket.defaultstore.common.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author vishnu_tiwary@thbs.com
 * 
 * @category The ProductController class is the main user entry point of Product
 *           API. It is expected that all product activity takes place through
 *           this class only.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Api(value = "product", description = "Rest API for product related operations", tags = "Product API")
public class ProductController {

	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

	/**
	 * @param product
	 * @param ucBuilder
	 * @return ResponseEntity for the list of product dto's.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/products")
	@ApiOperation(value = "Display products", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<List<ProductDTO>> getAll() {
		List<ProductDTO> products = (ArrayList<ProductDTO>) productService.findAll();
		if (products.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}

	/**
	 * @param productBean
	 * @return ResponseEntity for the created product.
	 */
	@PostMapping(value = "/products")
	@ApiOperation(value = "Create products", response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<?> save(@RequestBody ProductBean productBean) {
		ProductDTO productDTO = productService.save(productBean);
		File currDir = new File(".");
		String projectpath = currDir.getAbsolutePath();
		projectpath = projectpath.substring(0, projectpath.length() - 1);

		File sFile = new File(projectpath + "src//main//resources//static//temp");
		// Find files in source folder
		File[] sourceFiles = sFile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				ProductImageBean productImageBean = new ProductImageBean();
				productImageBean.setImageName(name);
				productImageBean.setImagePath("src//main//resources//static//appimages//product_"+productDTO.getProductId()+"//"+name);
				productImageBean.setProductId(productDTO.getProductId());
				productService.saveProductImage(productImageBean);
				return true;
			}
		});
		for (File fSource : sourceFiles) {
			new File("src//main//resources//static//Products//product_"+productDTO.getProductId()).mkdir();
            File fTarget = new File(new File(projectpath + "src//main//resources//static//Products//product_"+productDTO.getProductId()+"//"), fSource.getName());
			Util.copyFileUsingStream(fSource, fTarget);
			fSource.delete();
		}
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}

	/**
	 * @param productImage
	 * @return adding Product image to Temp folder.
	 */
	@PostMapping(value = "/upload")
	@ApiOperation(value = "Upload products", response = ProductDTO.class)
	public @ResponseBody Object upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if (file.isEmpty()) {
			request.setAttribute("message", "Please select a file to upload");
			return "uploadStatus";
		}
		File currDir = new File(".");
		String projectpath = currDir.getAbsolutePath();
		projectpath = projectpath.substring(0, projectpath.length() - 1);
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(projectpath + "src//main//resources//static//temp//" + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Success";
	}
	/**
	 * @param productImage
	 * @return Deleting Product image from Temp folder.
	 */
	@PostMapping(value = "/deleteTempImage")
	@ApiOperation(value = "Delete product Image", response = ProductDTO.class)	
	public @ResponseBody Object deleteTempImage(@RequestParam("name") String filename) {		
		File currDir = new File(".");
		String projectpath = currDir.getAbsolutePath();
	    projectpath = projectpath.substring(0, projectpath.length()-1);  	    
	    File tempFile = new File(projectpath + "src//main//resources//static//temp//"+filename);	    
	    tempFile.delete();	    
		return "Success";
	}
}