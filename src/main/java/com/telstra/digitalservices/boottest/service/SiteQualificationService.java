/**
 * @api {get} ?lat=:lat&lng=:lng Request Site Qualification
 * @apiName GetSiteQualification
 * @apiGroup service name
 * @apiVersion 0.1.0
 * @apiDescription This is documentation for SiteQualification service
 * This API now accepts LocationId and is given preference when queried along with lat/lng.
 *
 * @apiParam {String} lat Site latitude.
 * @apiParam {String} lng Site Langitude.
 * @apiParam {String} locationId Site Location.
 *
 * @apiError (Error 5xx) {503} 010000 Parameter not found
 * @apiError (Error 4xx) {422} 012000 NBN Co. has encountered an exception
 *
 * @apiSuccess (Serviceable) {String} status Status of request from downstream
 *
 *
 * @apiSuccess (Rejected) {String} status Status of request from downstream
 * @apiSuccess (Rejected) {Json} note Reason of rejection
 * <code>{
 *    "description" : "Premises is a Greenfields Location with an in-flight NTD pre-install request"
 * }</code>
 *
 * @apiSuccessExample  {json} Success-Response:
 *      HTTP/1.1 200 OK
 *      {
 *          "correlationId" : "9ff5a923-a44e-41d9-b634-b2707fe3fbef",
 *          "data" : {
 *              "status" : "Serviceable",
 *              "locid" : "LOC000033782101",
 *              "address" : {
 *                  "roadNumber1" : "12",
 *                  "roadName" : "SWAN",
 *                  "roadTypeCode" : "ST",
 *                  "roadSuffixCode" : "N",
 *                  "localityName" : "EAST MELBOURNE",
 *                  "stateTerritoryCode" : "VIC"
 *              },
 *              "resourceLocation" : {
 *                  "locid" : "LOC000033782102",
 *                  "type" : "Resource Location",
 *                  "locationType" : "COMMS ROOM",
 *                  "address" : {
 *                      "roadNumber1" : "12",
 *                      "roadName" : "SWAN",
 *                      "roadTypeCode" : "ST",
 *                      "roadSuffixCode" : "N",
 *                      "localityName" : "EAST MELBOURNE",
 *                      "stateTerritoryCode" : "VIC"
 *                  }
 *              },
 *              "lat" : -37.56487657,
 *              "lng" : 144.96534778,
 *              "accessTechnology" : "Fiber",
 *              "serviceabilityClass" : "3",
 *              "csaId" : "CSA000216237702",
 *              "productFeatures" : [{
 *                  "productName" : "High Speed TC2 (greater or equal to 20Mbps)",
 *                  "available" : false
 *              }],
 *              "ntds" : [{
 *                  "id" : "NTD898499882222",
 *                  "location" : "INDOOR",
 *                  "type" : "INTERNAL",
 *                  "powerType" : "DC",
 *                  "batteryPowerUnit" : "Yes",
 *                  "uncommittedUpstreamBandwidth" : "400Mbps",
 *                  "uncommittedDownstreamBandwidth" : "900Mbps",
 *                  "portStatuses" : [{
 *                      "portName": "UNI-D-1Status",
 *                      "status" : "Used"
 *                  }]
 *              }]
 *          },
 *          "time" : "2015-11-04T17:06:15.976+1100",
 *          "code" : 200,
 *          "request": {
 *              "correlationId" : "88c59f3b-8bb3-413d-9d95-27117fed7e13",
 *              "path" : "/nbn/siteQualification/v1",
 *              "method" : "GET",
 *              "data" : {
 *              },
 *              "params": {
 *                  "lng" : "67.5",
 *                  "lat" : "34.63"
 *              }
 *          }
 *      }
 *
 * @apiErrorExample  {json} Error-Response:
 *      HTTP/1.1 503  Service Unavailable
 *      {
 *          "code" : "010000"
 *          "error" : "Parameter not found"
 *      }
 */
package com.telstra.digitalservices.boottest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by c961723 on 11/10/2015.
 */
@RestController
public class SiteQualificationService {
    private Logger log = LoggerFactory.getLogger(SiteQualificationService.class);


    @RequestMapping(method = RequestMethod.GET, path="/test")
    @ResponseBody
    public Object doGet(@RequestParam String lat, @RequestParam String lng) throws Exception {
        return "{'msg':'hello world!'}";
    }

}