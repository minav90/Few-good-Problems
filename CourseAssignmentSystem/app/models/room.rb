class Room < ActiveRecord::Base
	self.primary_key = "room_id"
	belongs_to :building
	belongs_to :classroomtiming
end
