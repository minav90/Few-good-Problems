# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)
# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)
buildings = [{:building_id => '1', :building_name => 'HRBB'},
    	  {:building_id => '2', :building_name => 'CHEN'},
    	  {:building_id => '3', :building_name => 'FERM'},
  	       ]

buildings.each do |building|
  Building.create!(building)
end

rooms = [{:room_id => '1', :building_id => '1', :room_name => '124'},
    	  {:room_id => '2', :building_id => '2', :room_name => '108'},
    	  {:room_id => '3', :building_id => '3', :room_name => '303'},
  	       ]

rooms.each do |room|
  Room.create!(room)
end

slots = [{:timeslot_id => '1', :slot_num => '8.00 - 10.00'},
    	  {:timeslot_id => '2', :slot_num => '10.00 - 12.00'},
    	  {:timeslot_id => '3', :slot_num => '12.00 - 14.00'},
  	       ]

slots.each do |slot|
  TimeSlot.create!(slot)
end

classes = [{:classroomtiming_id => '1', :room_id => '1', :timeslot_id => '1'},
    	  {:classroomtiming_id => '2', :room_id => '1', :timeslot_id => '2'},
    	  {:classroomtiming_id => '3', :room_id => '1', :timeslot_id => '3'},
  	       ]

classes.each do |classroom|
  ClassroomTiming.create!(classroom)
end