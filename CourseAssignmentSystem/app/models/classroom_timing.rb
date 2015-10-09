class ClassroomTiming < ActiveRecord::Base
	
	has_many :room
	has_many :time_slot

	
end
