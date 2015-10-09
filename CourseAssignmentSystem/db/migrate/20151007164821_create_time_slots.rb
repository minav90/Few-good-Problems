class CreateTimeSlots < ActiveRecord::Migration
  def change
    create_table :time_slots do |t|
      t.integer :timeslot_id
      t.text :slot_num

      t.timestamps null: false
    end
  end
end
