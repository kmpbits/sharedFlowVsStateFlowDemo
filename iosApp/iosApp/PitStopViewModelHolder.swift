//
//  PitStopViewModelHolder.swift
//  iosApp
//
//  Created by Joel Caetano on 22/03/2026.
//

import Foundation
import Shared

@MainActor
final class PitStopViewModelHolder: ObservableObject {
    private let wrapper = PitStopViewModelWrapper()
    
    @Published private(set) var lapCount = 0
    @Published private(set) var alertMessage: String? = nil
    
    init () {
        wrapper.observeLapCount { [weak self] count in
            self?.lapCount = Int(truncating: count)
        }
        
        wrapper.observePitStopAlert { [weak self] message in
            self?.alertMessage = message
        }
    }
    
    func nextLap() {
        wrapper.nextLap()
    }
    
    func triggerPitStop(reason: String) {
        wrapper.triggerPitStop(reason: reason)
    }
    
    func reset() {
        wrapper.reset()
    }
    
    deinit {
        wrapper.dispose()
    }
}
