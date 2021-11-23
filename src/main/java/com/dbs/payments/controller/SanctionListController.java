package com.dbs.payments.controller;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import com.dbs.payments.model.SanctionList;
import com.dbs.payments.service.SanctionService;

@RestController
public class SanctionListController {

	@Autowired
	SanctionService sancService;
	
	@GetMapping("/getsanclist-name/{name}")
	public Boolean getSanctionName(@PathVariable(name = "name") String name)
	{
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "name is available.");
//		return new SanctionList(sancService.getSanctionName(name));
//		if(sancService.getSanctionName(name))
//		{
//			JSONObject jo = new JSONObject();
//			jo.put("isValid", "false");
//			return jo;
//		}
//		else
//		{
//			JSONObject jo = new JSONObject();
//			jo.put("isValid", "true");
//			return jo;
//		}
		return sancService.getSanctionName(name);
	}
}
