class CreateClassroomTimings < ActiveRecord::Migration
  def change
    create_table :classroom_timings do |t|
      t.integer :room_id
      t.integer :timeslot_id

      t.timestamps null: false
    end
  end
end
