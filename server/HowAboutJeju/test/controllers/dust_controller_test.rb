require 'test_helper'

class DustControllerTest < ActionDispatch::IntegrationTest
  test "should get update_data" do
    get dust_update_data_url
    assert_response :success
  end

  test "should get get_data" do
    get dust_get_data_url
    assert_response :success
  end

end
