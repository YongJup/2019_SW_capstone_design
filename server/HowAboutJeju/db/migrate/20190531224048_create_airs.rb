class CreateAirs < ActiveRecord::Migration[5.2]
  def change
    create_table :airs do |t|
      t.string :name
      t.datetime :dataTime
      t.integer :pm10Value
      t.integer :pm10Grade
      t.integer :pm25Value
      t.integer :pm25Grade

      t.timestamps
    end
  end
end
