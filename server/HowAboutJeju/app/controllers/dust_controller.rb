class DustController < ApplicationController
  
  def set_data

  end
  
  def update_data
    key = ''
    url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey="+ key + "&sidoName=#{URI.encode('제주')}&ver=1.3&_returnType=json"
    page = RestClient.get(url)
    doc = JSON.parse(page)
    
    (0..4).each do |i|
      air = Air.new
      air.name = doc['list'][i]['stationName']
      air.dataTime = doc['list'][i]['dataTime']
      air.pm10Value = doc['list'][i]['pm10Value']
      air.pm10Grade = doc['list'][i]['pm10Grade']
      air.pm25Value = doc['list'][i]['pm25Value']
      air.pm25Grade = doc['list'][i]['pm25Grade']
      air.airGrade = doc['list'][i]['khaiGrade']
      air.save
    end
  end

  def get_data
    @air = Air.all
    render json: @air
  end
end
