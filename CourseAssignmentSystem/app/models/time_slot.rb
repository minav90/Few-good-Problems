class TimeSlot < ActiveRecord::Base
	self.primary_key = "timeslot_id"
	belongs_to :classroomtiming
end
