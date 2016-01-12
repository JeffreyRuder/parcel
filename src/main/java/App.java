import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/home.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/results", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        int length = Integer.parseInt(request.queryParams("length"));
        int width = Integer.parseInt(request.queryParams("width"));
        int height = Integer.parseInt(request.queryParams("height"));
        int weight = Integer.parseInt(request.queryParams("weight"));
        int distance = Integer.parseInt(request.queryParams("distance"));
        String wrap = request.queryParams("wrap");
        boolean wrapRequest = false;
        int totalCost;

        if (wrap.equals("Yes")) {
          wrapRequest = true;
        }

        Parcel customerParcel = new Parcel(length, width, height, weight);
        ShippingRequest customerShippingRequest = new ShippingRequest(distance, wrapRequest);

        double baseCostInt = (customerParcel.cost_to_ship(customerShippingRequest.getDistance())) / 100.0;
        double wrapCostInt = (customerParcel.cost_to_giftwrap()) / 100.0;

        String baseCost = String.format("$%.2f", baseCostInt);
        String wrapCost = String.format("$%.2f", wrapCostInt);

        if (wrapRequest) {
           totalCost = customerParcel.cost_to_ship(customerShippingRequest.getDistance()) + customerParcel.cost_to_giftwrap();
        } else {
          totalCost = customerParcel.cost_to_ship(customerShippingRequest.getDistance());
        }

        double totalAsDouble = totalCost / 100.0;
        String totalAsString = String.format("$%.2f", totalAsDouble);

        request.session().attribute("basecost", baseCost);
        request.session().attribute("wrapcost", wrapCost);
        request.session().attribute("totalasstring", totalAsString);
        request.session().attribute("totalcost", totalCost);

        model.put("basecost", baseCost);
        model.put("wrapcost", wrapCost);
        model.put("totalasstring", totalAsString);

        model.put("totalcost", totalCost);
        model.put("customerParcel", customerParcel);
        model.put("customerShippingRequest", customerShippingRequest);

        model.put("template", "templates/results.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    }
}
